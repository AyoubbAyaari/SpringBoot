import { Component, OnInit } from '@angular/core';
import { Ingenieur } from '../model/ingenieur.model';
import { IngenieurService } from '../services/ingenieur.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-ingenieurs',
  templateUrl: './ingenieurs.component.html',
  styleUrls: ['./ingenieurs.component.css']
})
export class IngenieursComponent implements OnInit {
  
  ngOnInit(): void {
    this.chargerIngenieurs()
      };
      
  
  ingenieurs!: Ingenieur[] ;
  constructor(private ingenieurService : IngenieurService ,public authService: AuthService) {
   // this.ingenieurs = ingenieurService.listeIngenieurs();  
}
chargerIngenieurs(){
  this.ingenieurService.listeIngenieurs().subscribe(prods => {
  console.log(prods);
  this.ingenieurs = prods;
  }); 
}
  


  supprimerIngenieur(p: Ingenieur)
  {
  let conf = confirm("Etes-vous sûr ?");
  if (conf)
  this.ingenieurService.supprimerIngenieur(p.idIngenieur).subscribe(() => {
  console.log("produit supprimé");
  this.chargerIngenieurs();
  });
  }
}
