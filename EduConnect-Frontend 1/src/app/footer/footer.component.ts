import { Component } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faFacebookF, faTwitter, faInstagram, faLinkedinIn, faYoutube } from '@fortawesome/free-brands-svg-icons';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [MatToolbarModule, MatButtonModule, RouterModule, FontAwesomeModule],
  template: `
    <footer class="bg-primary text-light py-3">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-4">
            <a href="#" class="text-light font-weight-bold h5 mb-0">EduConnect</a>
          </div>
          <div class="col-md-4 text-center">
            <a href="#" class="text-light mx-2">Disclaimer</a>
            <a href="#" class="text-light mx-2">Cookie Settings</a>
            <a href="#" class="text-light mx-2">Privacy Policy</a>
          </div>
          <div class="col-md-4 text-right">
            <span class="mr-2">Follow EduConnect on</span>
            <a href="#" class="text-light mx-1 social-icon"><fa-icon [icon]="faFacebookF"></fa-icon></a>
            <a href="#" class="text-light mx-1 social-icon"><fa-icon [icon]="faTwitter"></fa-icon></a>
            <a href="#" class="text-light mx-1 social-icon"><fa-icon [icon]="faInstagram"></fa-icon></a>
            <a href="#" class="text-light mx-1 social-icon"><fa-icon [icon]="faLinkedinIn"></fa-icon></a>
            <a href="#" class="text-light mx-1 social-icon"><fa-icon [icon]="faYoutube"></fa-icon></a>
          </div>
        </div>
      </div>
    </footer>
  `,
  styles: [`
    /* Remove the position rule if the footer's position is handled globally */
    footer {
      width: 100%;
      background-color: #056edc;
      color: #f8f9fa;
      padding: 1rem 0;
      text-align: center;
    }

    .bg-primary {
      background-color: #056edc !important;
    }

    .text-light {
      color: #f8f9fa !important;
    }

    .font-weight-bold {
      font-weight: 700 !important;
    }

    .h5 {
      font-size: 1.25rem;
    }

    a {
      text-decoration: none;
    }

    a:hover {
      text-decoration: underline;
    }

    .social-icon {
      display: inline-block;
      width: 30px;
      height: 30px;
      line-height: 30px;
      text-align: center;
      border-radius: 50%;
      background-color: rgba(255, 255, 255, 0.2);
      transition: background-color 0.3s ease;
    }

    .social-icon:hover {
      background-color: rgba(255, 255, 255, 0.3);
      text-decoration: none;
    }
    footer {
      position: relative;
      bottom: 0;
      width: 100%;
    }

  `]
})
export class FooterComponent {
  faFacebookF = faFacebookF;
  faTwitter = faTwitter;
  faInstagram = faInstagram;
  faLinkedinIn = faLinkedinIn;
  faYoutube = faYoutube;
}
