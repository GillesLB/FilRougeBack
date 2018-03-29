import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AffairesService } from '../../services/affaires.service';
import { MatDialog, MatSort, MatTableDataSource } from '@angular/material';
import { Affaires } from '../../modeles/affaires';
import { People } from '../../modeles/people';
import { DialogDeleteComponent } from '../dialog/dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-tab-personne',
  templateUrl: './tab-personne.component.html',
  styleUrls: ['./tab-personne.component.css']
})
export class TabPersonneComponent implements OnInit {

  constructor(private route: ActivatedRoute, private affaireService: AffairesService, private router: Router, private dialog: MatDialog) { }

  id: number;
  personne: People[];
  errText: string;
  displayedColumns = ['id', 'firstName', 'lastName', 'nickName', 'status', 'editer', 'ajouter', 'supprimer'];
  dataSource = new MatTableDataSource<People>(this.personne);
  @ViewChild(MatSort) sort: MatSort;



  ngOnInit() {
    this.route.paramMap.subscribe(params => this.id = +params.get('id'));
    this.getPersonne();
  }

  getPersonne() {
    this.affaireService.getAffaire(this.id).subscribe(affaire => {
      this.personne = affaire.people;
      this.dataSource = new MatTableDataSource<People>(this.personne);
      this.dataSource.sort = this.sort;
    });
  }

  deletePersonne(idPersonne) {
    this.affaireService.deletePersonne(this.id, idPersonne).subscribe(() => {
      this.getPersonne();
    });
  }

  openDeleteDialog(idPersonne): void {
    const dialogRef = this.dialog.open(DialogDeleteComponent, { width: '250px' });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.deletePersonne(idPersonne);
      }
    });
  }
}
