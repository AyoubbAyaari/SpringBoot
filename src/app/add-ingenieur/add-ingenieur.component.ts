import { Component, OnInit } from '@angular/core';
import { Ingenieur } from '../model/ingenieur.model';
import { IngenieurService } from '../services/ingenieur.service';
import { ActivatedRoute,Router } from '@angular/router';
import { Projet } from '../model/projet.model';


@Component({
  selector: 'app-add-ingenieur',
  templateUrl: './add-ingenieur.component.html',
  styleUrls: ['./add-ingenieur.component.css']
})
export class AddIngenieurComponent implements OnInit {
  projets! : Projet[];
newIdProj! : number;
newProjet! : Projet;

  newIngenieur = new Ingenieur();
  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
      
    private ingenieurService : IngenieurService){}
  ngOnInit(): void {
    this.ingenieurService.listeProjets().
subscribe(cats => {console.log(cats);
  this.projets=cats._embedded.projets;
});
  }

  addIngenieur(){
    this.newIngenieur.projet = this.projets.find(cat => cat.idProj == this.newIdProj)!;
this.ingenieurService.ajouterIngenieur(this.newIngenieur)
.subscribe(prod => {
console.log(prod);

    
    this.router.navigate(['/ingenieurs']);
    });
}
}
