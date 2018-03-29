import {
  Component,
  OnInit,
  ViewChild
} from '@angular/core';
import { Router, Route, ActivatedRoute } from '@angular/router';
import { Affaires } from '../modeles/affaires';
import { AffairesService } from '../services/affaires.service';
import { MatTableDataSource, MatSort, MatPaginator } from '@angular/material';
import { Vehicule } from '../modeles/vehicule';
import { ApiService } from '../../api.service';
import { NgxSpinnerService } from 'ngx-spinner';


@Component({
  selector: 'app-affaire',
  templateUrl: './affaires.component.html',
  styles: ['./affaires.component.css']
})


export class AffairesComponent implements OnInit {


  constructor(private api: ApiService, private router: Router,
    private route: ActivatedRoute, private spinner: NgxSpinnerService) { }

  affaires: Affaires[];
  id: number;
  vehicules: Vehicule[];
  displayedColumns = ['id', 'nom', 'description', 'dateCreation', 'dateModification', 'editer'];
  dataSource = new MatTableDataSource<Affaires>(this.affaires);
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit() {

    this.spinner.show();
    setTimeout(() => { this.spinner.hide(); }, 5000);

    this.api.getAffaires()
      .subscribe(data => {
        this.affaires = data;
        this.dataSource = new MatTableDataSource<Affaires>(this.affaires);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;

      });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


}
