import { Component, OnInit, ViewChild } from '@angular/core';
import { ApiService } from '../../../api.service';
import { Affaires } from '../../modeles/affaires';
import { Vehicule } from '../../modeles/vehicule';
import { MatTableDataSource, MatSort, MatDialog } from '@angular/material';
import { Route } from '@angular/compiler/src/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AffairesService } from '../../services/affaires.service';
import { Observable } from 'rxjs/Observable';
import { DialogDeleteComponent } from '../dialog/dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-tab-vehicule',
  templateUrl: './tab-vehicule.component.html',
  styleUrls: ['./tab-vehicule.component.css']
})
export class TabVehiculeComponent implements OnInit {

  constructor(private route: ActivatedRoute, private affaireService: AffairesService,
    private router: Router, private dialog: MatDialog, private api: ApiService) { }

  id: number;
  vehicule: Vehicule[];
  errText: string;
  displayedColumns = ['id', 'marque', 'model', 'color', 'license', 'editer', 'ajouter', 'supprimer'];
  dataSource = new MatTableDataSource<Vehicule>(this.vehicule);
  @ViewChild(MatSort) sort: MatSort;



  ngOnInit() {
    this.route.paramMap.subscribe(params => this.id = +params.get('id'));
    this.getVehicule();
  }

  getVehicule() {
    this.affaireService.getAffaire(this.id).subscribe(affaire => {
      this.vehicule = affaire.vehicule;
      this.dataSource = new MatTableDataSource<Vehicule>(this.vehicule);
      this.dataSource.sort = this.sort;
    });
  }

  deleteVehicule(idVehicule) {
    this.affaireService.deleteVehicule(this.id, idVehicule).subscribe(() => {
      this.getVehicule();
    });
  }

  openDeleteDialog(idVehicule): void {
    const dialogRef = this.dialog.open(DialogDeleteComponent, { width: '250px' });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.deleteVehicule(idVehicule);
      }
    });
  }
}
