import { Component, OnInit } from '@angular/core';
import { Fiche } from '../fiche';
import { Kamban } from '../kamban';
import { KambanAPIServiceService } from '../kamban-apiservice.service';
import { Section } from '../section';
import { Utilisateur } from '../utilisateur';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css'],
  providers: [KambanAPIServiceService]
})
export class MyComponentComponent implements OnInit {

  id!: string;

  idKamban!: number;
  libelleKamban!: string;
  etatcreate!: string;
  etatcreateFiche!: string;
  etatcreateSection!: string;
  etatcreateUtilisateur!: string;
  

  libelleFiche!: string;
  tempsFiche!: string;
  noteFiche!: string;
  SectionFiche!: string;
  urlFiche!: string;
  utilisateur!: string;

  libelleSection!: string;
  kambanAssocie!: string;

  email!: string;
  nom!: string;

  kambans : Kamban[]=[];
  selectedKambanId!: number;
  searchKambanLibelle!:string

  utilisateurs : Utilisateur[]=[];
  selectedUtilisateurId!: number;
  searchUtilisateurLibelle!:string

  sections : Section[]=[];
  selectedSectionId!: string;
  searchSectionLibelle!:string

  fiches : Fiche[]=[];
  selectedFicheId!: number;
  searchFicheLibelle!:string

  constructor( private kamBanService : KambanAPIServiceService) {

   }

  ngOnInit(): void {

    this.kamBanService.getKanbams().subscribe((data)=>{

      data.forEach((e: {id: number, libelle: string; }) => {
        this.kambans.push(new Kamban(e.id, e.libelle));
      });
    
    });

    this.kamBanService.getFiches().subscribe((data)=>{

      data.forEach((e: {id: number, libelle: string, tempsFiche: string, 
        noteFiche: string, SectionFiche: string, urlFiche: string, utilisateur: string;}) => {
        this.fiches.push(new Fiche(e.id, e.libelle, e.tempsFiche, e.noteFiche, e.SectionFiche,
          e.urlFiche,e.utilisateur));
      });
    
    });

    this.kamBanService.getSection().subscribe((data)=>{

      data.forEach((e: {id: number, libelle: string, libelleAssocie: string;}) => {
        this.sections.push(new Section(e.id, e.libelle, e.libelleAssocie));
      });
    
    });

    this.kamBanService.getUtilisateur().subscribe((data)=>{

      data.forEach((e: {email: string, nom: string;}) => {
        this.utilisateurs.push(new Utilisateur(e.email, e.nom));
      });
    
    });

    
  }

  createKamban(){

    this.kamBanService.addKamban(new Kamban(this.idKamban ,this.libelleKamban)).subscribe(data => this.kambans.push(data));
    this.etatcreate='Succès';
  }

  createFiche(){

    this.kamBanService.addFiche(new Fiche(this.fiches.length+1,this.libelleFiche ,this.tempsFiche,
      this.noteFiche,this.SectionFiche,this.urlFiche,this.utilisateur)).subscribe(data => this.fiches.push(data));
    this.etatcreateFiche='Succès';
  }

  
  createSection(){

    this.kamBanService.addSection(new Section(this.sections.length+1,this.libelleSection, this.kambanAssocie)).subscribe(data => this.sections.push(data));
    this.etatcreateSection='Succès';

  }


  createUtilisateur(){

    this.kamBanService.addUtilisateur(new Utilisateur(this.email, this.nom)).subscribe(data => this.utilisateurs.push(data));
    this.etatcreateUtilisateur='Succès';

  }

}
