import { Injectable } from '@angular/core';
import { Ingenieur } from '../model/ingenieur.model';
import { Projet } from '../model/projet.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProjetWrapper } from '../model/ProjetWrapper.model';
const httpOptions = {
  headers: new HttpHeaders( {'Content-Type': 'application/json'} )
};

@Injectable({
  providedIn: 'root'
})
export class IngenieurService {
  apiURL: string = 'http://localhost:8081/miniprojet/api';
  apiURLProj: string = 'http://localhost:8081/miniprojet/proj';
  ingenieurs !: Ingenieur[];
  ingenieur! : Ingenieur;
  projets! : Projet[];
  constructor(private http : HttpClient) {
    
    /*this.projets = [ {idProj : 1, nomProj : "usine"},
{idProj : 2, nomProj : "clinique"},
{idProj : 3, nomProj : "iset"}]; 
    this.ingenieurs = [
      { idIngenieur : 1, nomIngenieur : "Ayoub", Expertise : "3 ans", projet : {idProj : 1, nomProj : "usine"}},
      { idIngenieur : 2, nomIngenieur : "Azer", Expertise : "3 ans",projet : {idProj : 2, nomProj : "clinique"}},
      { idIngenieur : 3, nomIngenieur :"Israa", Expertise : "1ans",projet : {idProj : 1, nomProj : "iset"}}
      ];
      */
   }
   listeIngenieurs():Observable<Ingenieur[]> {
    
    return this.http.get<Ingenieur[]>(this.apiURL);
    }
    ajouterIngenieur( ing: Ingenieur):Observable<Ingenieur>{
      return this.http.post<Ingenieur>(this.apiURL, ing, httpOptions);
      }
      supprimerIngenieur(id : number){
        //supprimer le produit prod du tableau produits
        const url = `${this.apiURL}/${id}`;
        return this.http.delete(url, httpOptions);
        }
        //ou Bien
        /* this.produits.forEach((cur, index) => {
        if(prod.idProduit === cur.idProduit) {
        this.produits.splice(index, 1);
        }
        }); */
        
        consulterIngenieur(id:number): Observable<Ingenieur>{
          const url = `${this.apiURL}/${id}`;
          return this.http.get<Ingenieur>(url);

          }

          trierIngenieurs(){
            this.ingenieurs = this.ingenieurs.sort((n1,n2) => {
            if (n1.idIngenieur! > n2.idIngenieur!) {
            return 1;
            }
            if (n1.idIngenieur! < n2.idIngenieur!) {
            return -1;
            }
            return 0;
            });
            }
               
          updateIngenieur(prod:Ingenieur) : Observable<Ingenieur>
{
  return this.http.put<Ingenieur>(this.apiURL, prod, httpOptions);

}
listeProjets():Observable<ProjetWrapper> {
  return this.http.get<ProjetWrapper>(this.apiURLProj);

  } 
  consulterProjet(id:number): Projet{ 
    return this.projets.find(proj => proj.idProj == id)!;
    }
    rechercherParProjet(idProj: number):Observable< Ingenieur[]> {
      const url = `${this.apiURL}/prodscat/${idProj}`;
      return this.http.get<Ingenieur[]>(url);
      }
      rechercherParNom(nom: string):Observable< Ingenieur[]> {
        const url = `${this.apiURL}/prodsByName/${nom}`;
        return this.http.get<Ingenieur[]>(url);
        }
        ajouterProjet( cat: Projet):Observable<Projet>{
          return this.http.post<Projet>(this.apiURLProj, cat, httpOptions);
          }
}
