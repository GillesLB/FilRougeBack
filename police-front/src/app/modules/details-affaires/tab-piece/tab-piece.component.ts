import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MatDialog, MatTableDataSource, MatSort } from '@angular/material';
import { PieceOfEvidence } from '../../modeles/pieceofevidence';
import { AffairesService } from '../../services/affaires.service';
import { DialogDeleteComponent } from '../dialog/dialog-delete/dialog-delete.component';

@Component({
  selector: 'app-tab-piece',
  templateUrl: './tab-piece.component.html',
  styleUrls: ['./tab-piece.component.css']
})
export class TabPieceComponent implements OnInit {

  constructor(private route: ActivatedRoute, private affaireService: AffairesService,
    private router: Router, private dialog: MatDialog) { }

 id: number;
 piece: PieceOfEvidence[];
 errText: string;
 displayedColumns = ['id', 'type', 'serialNumber',  'editer', 'supprimer'];
 dataSource = new MatTableDataSource<PieceOfEvidence>(this.piece);
 @ViewChild(MatSort) sort: MatSort;



 ngOnInit() {
   this.route.paramMap.subscribe(params => this.id = +params.get('id'));
   this.getPiece();
 }

 getPiece() {
   this.affaireService.getAffaire(this.id).subscribe(affaire => {
     this.piece = affaire.pieceOfEvidence;
     this.dataSource = new MatTableDataSource<PieceOfEvidence>(this.piece);
     this.dataSource.sort = this.sort;
   });
 }

 deletePiece(idPiece) {
   this.affaireService.deletePiece(this.id, idPiece).subscribe(() => {
     this.getPiece();
   });
 }

 openDeleteDialog(idPiece): void {
   const dialogRef = this.dialog.open(DialogDeleteComponent, { width: '250px' });
   dialogRef.afterClosed().subscribe(result => {
     console.log('The dialog was closed');
     if (result) {
       this.deletePiece(idPiece);
     }
   });
 }
}

