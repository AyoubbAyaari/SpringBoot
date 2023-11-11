import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { IngenieurService } from '../services/ingenieur.service';
import { Ingenieur } from '../model/ingenieur.model';
import { Projet } from '../model/projet.model';

@Component({
  selector: 'app-update-ingenieur',
  templateUrl: './update-ingenieur.component.html',
  styles: []
})
export class UpdateIngenieurComponent implements OnInit {
  
  currentIngenieur = new Ingenieur();
  projets! : Projet[];
updatedProjId! : number;
  

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private ingenieurService: IngenieurService) { }
    


  ngOnInit(): void {
    this.ingenieurService.listeProjets().
subscribe(cats => {console.log(cats);
  this.projets=cats._embedded.projets;
});
this.ingenieurService.consulterIngenieur(this.activatedRoute.snapshot.params['id']).
subscribe( prod =>{ this.currentIngenieur = prod; 
this.updatedProjId = 
this.currentIngenieur.projet.idProj;
} ) ;


  }
  updateIngenieur()
{
  this.currentIngenieur.projet = this.projets.
 find(cat => cat.idProj == this.updatedProjId)!;
this.ingenieurService.updateIngenieur(this.currentIngenieur).subscribe(prod => {
this.router.navigate(['/ingenieurs']);
})
}}
