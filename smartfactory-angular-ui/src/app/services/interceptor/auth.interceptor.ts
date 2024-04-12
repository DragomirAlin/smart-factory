import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {KeycloakService} from 'keycloak-angular';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private keycloakService: KeycloakService) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let authReq = req;
    const token = this.keycloakService.getToken() || '';
    if (token != null) {
      authReq = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`,
        },

      });
    }
    return next.handle(authReq);
  }
}

export const authInterceptorProviders = [
  {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}
];
