import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AffairesComponent } from '../affaires/affaires.component';
import { AddAffairesComponent } from '../add-affaires/add-affaires.component';
import { DetailsAffairesComponent } from '../details-affaires/details-affaires.component';
import { TabPersonneComponent } from '../details-affaires/tab-personne/tab-personne.component';
import { TabVehiculeComponent } from '../details-affaires/tab-vehicule/tab-vehicule.component';
import { TableCrudPersonneComponent } from '../../table-crud-personne/table-crud-personne.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'affaires'
  },

  { path: 'affaires', component: AffairesComponent },
  { path: 'add', component: AddAffairesComponent },
  { path: 'table', component: TableCrudPersonneComponent },
  {
    path: 'affaires/:id', component: DetailsAffairesComponent,
    children: [
      { path: 'personne', component: TabPersonneComponent },
      { path: 'vehicule', component: TabVehiculeComponent },
      { path: 'edit', component: DetailsAffairesComponent },
      { path: 'posts', component: DetailsAffairesComponent }

    ]
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
