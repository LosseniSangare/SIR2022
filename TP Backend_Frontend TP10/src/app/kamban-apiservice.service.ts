import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fiche } from './fiche';
import { Kamban } from './kamban';
import { Section } from './section';
import { Utilisateur } from './utilisateur';

@Injectable({
  providedIn: 'root'
})
export class KambanAPIServiceService {

  constructor( private http: HttpClient) { }

  getKanbams() : Observable<any> {

    return this.http.get('/api/kamban/all');
    
  }
  
  getKanbamInfo() : Observable<any> {

    return this.http.get('/api/kamban/all');
    
  }

addKamban(kanbam: Kamban): Observable<Kamban> {
  return this.http.post<Kamban>('/api/kamban/add',Kamban);

}





getFiches() : Observable<any> {

  return this.http.get('/api/fiches/all');
  
}

addFiche(fiche: Fiche): Observable<Fiche> {
  return this.http.post<Fiche>('/api/fiches/add',Fiche);
  
  }

  getSection() : Observable<any> {

    return this.http.get('/api/section/all');
    
  }
  
  addSection(section: Section): Observable<Section> {
    return this.http.post<Section>('/api/section/add',Section);
    
    }


    getUtilisateur() : Observable<any> {

      return this.http.get('/api/user/all');
      
    }
    
    addUtilisateur(utilisateur: Utilisateur): Observable<Utilisateur> {
      return this.http.post<Utilisateur>('/api/user/add',Utilisateur);
      
      }



}
