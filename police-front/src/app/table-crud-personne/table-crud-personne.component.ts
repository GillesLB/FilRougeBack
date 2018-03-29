import { Component, OnInit } from '@angular/core';
import { AffairesService } from '../modules/services/affaires.service';
import { People } from '../modules/modeles/people';
import { Affaires } from '../modules/modeles/affaires';
import { ApiService } from '../api.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-table-crud-personne',
  templateUrl: './table-crud-personne.component.html',
  styleUrls: ['./table-crud-personne.component.css']
})
export class TableCrudPersonneComponent implements OnInit {

  constructor(private affaireService: AffairesService, private api: ApiService, private spinner: NgxSpinnerService) { }

  displayDialog: boolean;
  affaires: Affaires[];
  affaire: Affaires = {};
  selectedAffaire: Affaires;
  newAffaire: boolean;
  cols: any[];


  ngOnInit() {
    this.spinner.show();
    setTimeout(() => { this.spinner.hide(); }, 5000);
    this.getAffaires();


    this.cols = [
      { field: 'id', header: 'id' },
      { field: 'name', header: 'Nom' },
      { field: 'description', header: 'Description' },
      { field: 'dateCreation', header: 'date' }
    ];
  }
  getAffaires() {
    this.api.getAffaires().subscribe(affaire => {
      this.affaires = affaire;
    });
  }
  showDialogToAdd() {
    this.newAffaire = true;
    this.affaire = {};
    this.displayDialog = true;
  }
  save() {
    if (this.newAffaire) {
      this.affaireService.createAffaire(this.affaire).subscribe(
        affaire => this.affaire = affaire,
      );
      this.spinner.show();
      setTimeout(() => { this.spinner.hide(); }, 5000);
      this.getAffaires();
    } else {
      this.affaireService.updateAffaire(this.affaire).subscribe(() => {
        this.spinner.show();
        setTimeout(() => {
          this.spinner.hide();
        }, 5000);
      });
      this.getAffaires();
    }

    this.getAffaires();
    this.affaire = null;
    this.displayDialog = false;
  }

  delete() {
    const index = this.affaires.indexOf(this.selectedAffaire);
    this.affaires = this.affaires.filter((val, i) => i !== index);
    this.affaire = null;
    this.displayDialog = false;
  }

  onRowSelect(event) {
    this.newAffaire = false;
    this.affaire = this.cloneAffaire(event.data);
    this.displayDialog = true;
  }

  cloneAffaire(c: Affaires): Affaires {
    const affaire = {};
    // tslint:disable-next-line:forin
    for (const prop in c) {
      affaire[prop] = c[prop];
    }
    return affaire;
  }
}
