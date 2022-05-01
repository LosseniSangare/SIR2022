import { Component, Input, OnInit } from '@angular/core';
import { PokeShareInfoService } from '../poke-share-info.service';
import { PokeDetail } from '../pokemon';

@Component({
  selector: 'app-pokedetail',
  templateUrl: './pokedetail.component.html',
  styleUrls: ['./pokedetail.component.css'],
  providers: [PokeShareInfoService]
})
export class PokedetailComponent implements OnInit {


  @Input('detail')
  detail!: PokeDetail

  constructor(private pokeShareInfoService: PokeShareInfoService) { }

  ngOnInit(): void {
    console.log(this.pokeShareInfoService.getValue());
  }

}
