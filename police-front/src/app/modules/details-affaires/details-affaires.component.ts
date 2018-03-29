import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatTableDataSource } from '@angular/material';
import { Affaires } from '../modeles/affaires';
import { Vehicule } from '../modeles/vehicule';
import { AffairesService } from '../services/affaires.service';
import { DialogDeleteComponent } from './dialog/dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-details-affaires',
  templateUrl: './details-affaires.component.html',
  styleUrls: ['./details-affaires.component.css']
})
export class DetailsAffairesComponent implements OnInit {

  constructor(private route: ActivatedRoute, private affaireService: AffairesService,
    private router: Router, private dialog: MatDialog) { }

  id: number;
  affaire: Affaires;
  vehicule: Vehicule[];
  errText: string;
  displayedColumns = ['id', 'marque', 'model', 'color', 'license'];



  ngOnInit() {
    this.route.paramMap.subscribe(params => this.id = +params.get('id'));
    this.affaireService.getAffaire(this.id).subscribe(affaire => {
      this.affaire = affaire;
      this.vehicule = affaire.vehicule;

    });

  }

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(DialogDeleteComponent, { width: '250px' });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      if (result) {
        this.deleteAffaire();
      }
    });
  }

  deleteAffaire() {
    this.affaireService.deleteAffaires(this.affaire.id).subscribe(
      () => { this.router.navigateByUrl('/'); },
      err => { console.log(err); }
    );
  }
}


