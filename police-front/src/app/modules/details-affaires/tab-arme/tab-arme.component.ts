import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AffairesService } from '../../services/affaires.service';
import { MatDialog, MatTableDataSource, MatSort } from '@angular/material';
import { Weapon } from '../../modeles/weapon';
import { DialogDeleteComponent } from '../dialog/dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-tab-arme',
  templateUrl: './tab-arme.component.html',
  styleUrls: ['./tab-arme.component.css']
})
export class TabArmeComponent implements OnInit {

  constructor(private route: ActivatedRoute, private affaireService: AffairesService,
     private router: Router, private dialog: MatDialog) { }

  id: number;
  arme: Weapon[];
  errText: string;
  displayedColumns = ['id', 'type', 'modele',  'editer', 'supprimer'];
  dataSource = new MatTableDataSource<Weapon>(this.arme);
  @ViewChild(MatSort) sort: MatSort;



  ngOnInit() {
    this.route.paramMap.subscribe(params => this.id = +params.get('id'));
    this.getArme();
  }

  getArme() {
    this.affaireService.getAffaire(this.id).subscribe(affaire => {
      this.arme = affaire.weapon;
      this.dataSource = new MatTableDataSource<Weapon>(this.arme);
      this.dataSource.sort = this.sort;
    });
  }

  deleteArme(idArme) {
    this.affaireService.deleteArme(this.id, idArme).subscribe(() => {
      this.getArme();
    });
  }

  openDeleteDialog(idArme): void {
    const dialogRef = this.dialog.open(DialogDeleteComponent, { width: '250px' });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.deleteArme(idArme);
      }
    });
  }
}
