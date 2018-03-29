import { Component, OnInit } from '@angular/core';
import { NgxGalleryOptions, NgxGalleryImage, NgxGalleryAnimation } from 'ngx-gallery';
import { ActivatedRoute, Router } from '@angular/router';
import { AffairesService } from '../../services/affaires.service';
import { MatDialog } from '@angular/material';
import { Photo } from '../../modeles/photo';

@Component({
    selector: 'app-tab-photo',
    templateUrl: './tab-photo.component.html',
    styleUrls: ['./tab-photo.component.css']
})
export class TabPhotoComponent implements OnInit {

    constructor(private route: ActivatedRoute, private affaireService: AffairesService,
        private router: Router, private dialog: MatDialog) { }

    galleryOptions: NgxGalleryOptions[];
    galleryImages: Photo[];
    id: number;
    link: string;
    errText: string;

    ngOnInit(): void {

        this.galleryOptions = [
            {
                width: '600px',
                height: '400px',
                thumbnailsColumns: 4,
                imageAnimation: NgxGalleryAnimation.Slide
            },
            // max-width 800
            {
                breakpoint: 800,
                width: '100%',
                height: '600px',
                imagePercent: 80,
                thumbnailsPercent: 20,
                thumbnailsMargin: 20,
                thumbnailMargin: 20
            },
            // max-width 400
            {
                breakpoint: 400,
                preview: false
            }

        ];

        this.route.paramMap.subscribe(params => this.id = +params.get('id'));
        this.affaireService.getAffaire(this.id).subscribe(affaire => {

            this.galleryImages = affaire.photo;



        });
    }
}
