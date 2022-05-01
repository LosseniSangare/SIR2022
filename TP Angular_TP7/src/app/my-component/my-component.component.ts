import { Component, OnInit } from '@angular/core';
import { PokeAPIServiceService } from '../poke-apiservice.service';
import { PokeShareInfoService } from '../poke-share-info.service';
import { PokeDetail, Pokemon } from '../pokemon';

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css'],
  providers: [PokeAPIServiceService, PokeShareInfoService]
})
export class MyComponentComponent implements OnInit  {
  id!: string;
  selectedPokeId!: string;
  pokes: Pokemon[]= [];
  pokeDetail!: PokeDetail;
  searchPokeName = '';
 
  constructor(private pokeService: PokeAPIServiceService, private pokeShareInfoService: PokeShareInfoService)
   { 

     }

  ngOnInit(): void {

    this.pokeService.getPokemons().subscribe((data) => {
    data.results.forEach((e, index ) => {
      this.pokes.push(new Pokemon(''+index, e.name, e.url));
    });

    }
    );

  }
  

  go(){

    this.pokeShareInfoService.setValue(this.selectedPokeId);

    if(this.selectedPokeId != ''){
       this.pokeService.getPokemonInfo(this.selectedPokeId).subscribe(data=>this.pokeDetail=data);
    }

  };


}

