<div>
  <ul>
    <li *ngFor='let hotel of hotelList'>{{hotel.name}}, {{hotel.stars}}, {{hotel.location}}, 
      {{hotel.accessible}}</li>
  </ul>

</div>

<input type="number" [(ngModel)]='starSearch' (change)='searchHotels()'>
<button class="btn-primary" (click)='searchHotels()'>get that baby</button>
<ul>
  <li *ngFor='let hotels of filteredList'>{{hotels.name}}</li>
</ul>

<button (click)="getemall('https://dog.ceo/api/breeds/image/random')">get em all</button>
<img [src]='thatthing'>