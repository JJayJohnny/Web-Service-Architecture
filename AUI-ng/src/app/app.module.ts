import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainComponent } from './component/main/main.component';
import { HeaderComponent } from './component/header/header.component';
import { AuthorListComponent } from './author/view/author-list/author-list.component';
import { HttpClientModule } from '@angular/common/http';
import { AuthorService } from './author/service/author.service';
import { NavComponent } from './component/nav/nav.component';
import { AuthorViewComponent } from './author/view/author-view/author-view.component';
import { AuthorAddComponent } from './author/view/author-add/author-add.component';
import { AuthorEditComponent } from './author/view/author-edit/author-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    HeaderComponent,
    AuthorListComponent,
    NavComponent,
    AuthorViewComponent,
    AuthorAddComponent,
    AuthorEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AuthorService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
