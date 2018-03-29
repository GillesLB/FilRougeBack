
import { Injectable } from '@angular/core';
import { ApiService } from '../../api.service';
import { tap } from 'rxjs/operators';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs/Subject';

import { Affaires } from '../modeles/affaires';


@Injectable()
export class AffairesService {

  selectedAffaire: Affaires;
  affaireReady$ = new Subject<Affaires>();

  constructor(private api: ApiService, ) { }

  getAffaire(id: number) {
    return this.api.getAffaire(id).pipe(
      tap(affaire => this.selectedAffaire = affaire),
      tap(affaire => this.affaireReady$.next(affaire))
    );
  }

  updateAffaire(affaire: Affaires): Observable<Affaires> {
    return this.api.updateAffaire(affaire);
  }

  createAffaire(affaire: Affaires): Observable<Affaires> {
    return this.api.createAffaire(affaire);
  }

  public deleteAffaires(id: number) {
    return this.api.deleteAffaire(id);
  }

  public deleteVehicule(idCase: number, idVehicule: number) {
    return this.api.deleteVehicule(idCase, idVehicule);
  }

  public deletePersonne(idCase: number, idPersonne: number) {
    return this.api.deletePersonne(idCase, idPersonne);
  }

  public deleteArme(idCase: number, idArme: number) {
    return this.api.deleteArme(idCase, idArme);
  }

  public deletePiece(idCase: number, idPiece: number) {
    return this.api.deletePiece(idCase, idPiece);
  }
}
