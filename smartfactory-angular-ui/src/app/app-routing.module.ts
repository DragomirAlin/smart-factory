import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DeviceComponent} from "./pages/device/device.component";
import {AuthGuard} from "./services/guard/auth.guard";
import {HomeComponent} from "./pages/home/home.component";
import {DatasetComponent} from "./pages/dataset/dataset.component";
import {NotificationComponent} from "./pages/notification/notification.component";
import {SubscriptionComponent} from "./pages/subscription/subscription.component";

const routes: Routes = [

  {
    path: 'device',
    component: DeviceComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '',
    component: HomeComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'dataset',
    component: DatasetComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'notification',
    component: NotificationComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'subscription',
    component: SubscriptionComponent,
    canActivate: [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AuthGuard]

})
export class AppRoutingModule {
}
