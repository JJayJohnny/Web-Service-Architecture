import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Books } from '../model/books';
import { BookDetails } from '../model/book-details';
import { BookForm } from '../model/book-form';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getBooks(): Observable<Books>{
    return this.http.get<Books>('/api/books');
  }

  getBook(uuid: String): Observable<BookDetails>{
    return this.http.get<BookDetails>('/api/books/'+uuid);
  }

  getAuthorBooks(uuid: String): Observable<Books>{
    return this.http.get<Books>('/api/authors/'+uuid+"/books");
  }

  deleteBook(uuid: String): Observable<any>{
    return this.http.delete('/api/books/'+uuid);
  }

  putBook(uuid: String, book: BookForm): Observable<any>{
    return this.http.put('/api/books/'+uuid, book);
  }
}
