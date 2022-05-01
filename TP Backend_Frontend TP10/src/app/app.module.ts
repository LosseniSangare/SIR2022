import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyComponentComponent } from './my-component/my-component.component';
import { FormsModule } from '@angular/forms';
import { FilterKambanPipePipe } from './filter-kamban--pipe.pipe';
import { FilterFichePipePipe } from './filter-fiche--pipe.pipe';
import { FilterSectionPipePipe } from './filter-section--pipe.pipe';
import { FilterUtilisateurPipePipe } from './filter-utilisateur--pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    MyComponentComponent,
    FilterKambanPipePipe,
    FilterFichePipePipe,
    FilterSectionPipePipe,
    FilterUtilisateurPipePipe
  ],
  imports: [
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
