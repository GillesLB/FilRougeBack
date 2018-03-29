import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Affaires } from './modules/modeles/affaires';
import { Vehicule } from './modules/modeles/vehicule';
import { People } from './modules/modeles/people';
import { PieceOfEvidence } from './modules/modeles/pieceofevidence';

@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }

  getAffaires(): Observable<Affaires[]> {
    return this.http
      .get<Affaires[]>('http://localhost:8080/api/case');
  }

  getAffaire(id: number): Observable<Affaires> {
    return this.http
      .get<Affaires>('http://localhost:8080/api/case/' + id);
  }
  updateAffaire(affaire: Affaires): Observable<Affaires> {
    return this.http
      .put<Affaires>('http://localhost:8080/api/case/' + affaire.id, affaire);
  }

  createAffaire(affaire: Affaires): Observable<Affaires> {
    return this.http
      .post<Affaires>('http://localhost:8080/api/case/', affaire);
  }

  deleteAffaire(id: number) {
    return this.http
      .delete<any>('http://localhost:8080/api/case/' + id);
  }

  deleteVehicule(idCase: number, idVehicule): Observable<Vehicule> {
    return this.http
      .delete<any>('http://localhost:8080/api/linkVehicule/' + idCase + '/' + idVehicule);
  }

  deletePersonne(idCase: number, idPersonne): Observable<People> {
    return this.http
      .delete<any>('http://localhost:8080/api/linkPeople/' + idCase + '/' + idPersonne);
  }

  deleteArme(idCase: number, idArme): Observable<People> {
    return this.http
      .delete<any>('http://localhost:8080/api/linkWeapon/' + idCase + '/' + idArme);
  }

  deletePiece(idCase: number, idPiece): Observable<PieceOfEvidence> {
    return this.http
      .delete<any>('http://localhost:8080/api/linkPiece/' + idCase + '/' + idPiece);
  }

}
