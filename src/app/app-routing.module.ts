import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IngenieursComponent } from './ingenieurs/ingenieurs.component';
import { AddIngenieurComponent } from './add-ingenieur/add-ingenieur.component';
import { UpdateIngenieurComponent } from './update-ingenieur/update-ingenieur.component';
import { RechercheParProjetComponent } from './recherche-par-projet/recherche-par-projet.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { ListeProjetComponent } from './liste-projet/liste-projet.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { IngenieurGuard } from './services/ingenieur.guard';


const routes: Routes = [
  {path: "ingenieurs", component : IngenieursComponent},
  {path: "add-ingenieur", component : AddIngenieurComponent , canActivate:[IngenieurGuard]},
  { path: "", redirectTo: "ingenieurs", pathMatch: "full" },
  {path: "updateIngenieur/:id", component: UpdateIngenieurComponent},
  {path: "rechercheParProjet", component : RechercheParProjetComponent},
  {path: "rechercheParNom", component : RechercheParNomComponent},
  {path: "listeProjet", component : ListeProjetComponent},
  {path: "login", component : LoginComponent},
  {path: 'app-forbidden', component: ForbiddenComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
