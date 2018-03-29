import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Affaires } from '../modeles/affaires';
import { AffairesService } from '../services/affaires.service';
import { Vehicule } from '../modeles/vehicule';
import { isDate } from 'util';

@Component({
  templateUrl: './add-affaires.component.html'
})
export class AddAffairesComponent implements OnInit {

  constructor(private router: Router, private affairesService: AffairesService) { }

  affaires: Affaires;
  vehicule: Vehicule;
  result: Array<Object>;

  ngOnInit() { }


  createAffaires(): void {


  }
}
