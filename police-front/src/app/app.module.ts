import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { AffairesComponent } from './modules/affaires/affaires.component';
import { AppRoutingModule } from './modules/routes/app-routing.module';
import { AffairesService } from './modules/services/affaires.service';
import { HttpClientModule } from '@angular/common/http';
import { AddAffairesComponent } from './modules/add-affaires/add-affaires.component';
import { FooterComponent } from './modules/footer/footer.component';
import { CommonModule } from '@angular/common';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './menu/menu.component';
import { CdkTableModule } from '@angular/cdk/table';
import { NgxGalleryModule } from 'ngx-gallery';
import { NgxSpinnerModule } from 'ngx-spinner';

import { MatMenuModule } from '@angular/material/menu';
import { MatTableModule } from '@angular/material/table';
import {
  MatInputModule, MatPaginatorModule, MatProgressSpinnerModule,
  MatSortModule, MatButtonModule, MatCheckboxModule, MatDialogModule, MatListModule, MatTabsModule
} from '@angular/material';
import {MatCardModule} from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { ApiService } from './api.service';
import { DetailsAffairesComponent } from './modules/details-affaires/details-affaires.component';
import { TabPersonneComponent } from './modules/details-affaires/tab-personne/tab-personne.component';
import { TabVehiculeComponent } from './modules/details-affaires/tab-vehicule/tab-vehicule.component';
import { TabArmeComponent } from './modules/details-affaires/tab-arme/tab-arme.component';
import { TabPhotoComponent } from './modules/details-affaires/tab-photo/tab-photo.component';
import { TabPieceComponent } from './modules/details-affaires/tab-piece/tab-piece.component';
import { DialogDeleteComponent } from './modules/details-affaires/dialog/dialog-delete/dialog-delete.component';
import {AccordionModule} from 'primeng/accordion';
import {MenuItem} from 'primeng/api';
import { DialogModule } from 'primeng/primeng';
import {TableModule} from 'primeng/table';
import { TableCrudPersonneComponent } from './table-crud-personne/table-crud-personne.component';





@NgModule({
  declarations: [
    AppComponent,
    AffairesComponent,
    AddAffairesComponent,
    FooterComponent,
    MenuComponent,
    DetailsAffairesComponent,
    TabPersonneComponent,
    TabVehiculeComponent,
    TabArmeComponent,
    TabPhotoComponent,
    TabPieceComponent,
    DialogDeleteComponent,
    TableCrudPersonneComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    FormsModule,
    CdkTableModule,
    MatTableModule,
    MatInputModule,
    MatPaginatorModule,
    MatProgressSpinnerModule,
    MatSortModule,
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatCardModule,
    MatDialogModule,
    MatListModule,
    MatTabsModule,
    NgxGalleryModule,
    NgxSpinnerModule,
    AccordionModule,
    TableModule,
    DialogModule,
    MatMenuModule
  ],
  providers: [AffairesService, ApiService],
  bootstrap: [AppComponent],
  entryComponents: [AffairesComponent, DialogDeleteComponent]

})
export class AppModule { }
