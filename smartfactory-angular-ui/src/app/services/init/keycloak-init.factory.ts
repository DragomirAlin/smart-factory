import {KeycloakService} from "keycloak-angular";
import {environment} from "../../../environments/environment";

export function initializeKeycloak(
  keycloak: KeycloakService,

  ) {
  return () =>
    keycloak.init({
      config: {
        url: environment.authUrl + '/auth',
        realm: environment.realm,
        clientId: environment.clientId,
      },
      initOptions: {
        onLoad: 'login-required',
        checkLoginIframe: true
      }
    })
}

