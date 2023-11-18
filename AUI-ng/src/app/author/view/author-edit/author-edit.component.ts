import { Component, OnInit } from '@angular/core';
import { AuthorForm } from '../../model/author-form';
import { AuthorService } from '../../service/author.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-author-edit',
  templateUrl: './author-edit.component.html',
  styleUrls: ['./author-edit.component.css']
})
export class AuthorEditComponent implements OnInit{

  uuid: String | undefined;
  author: AuthorForm | undefined;
  
  constructor(private service: AuthorService, 
              private route: ActivatedRoute,
              private router: Router){}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getAuthor(params['uuid']).subscribe(author => {
        this.author = {
          name: author.name,
          age: author.age
        }
        this.uuid = author.id
      })
    })
  }

  onSubmit(): void{
    this.service.putAuthor(this.uuid!, this.author!).subscribe(() => {
      this.router.navigate(['/authors']);
    })
  }
}
