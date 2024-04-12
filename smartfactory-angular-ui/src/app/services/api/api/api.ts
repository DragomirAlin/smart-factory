export * from './acquisition.service';
import { AcquisitionService } from './acquisition.service';
export * from './notification.service';
import { NotificationService } from './notification.service';
export * from './subscription.service';
import { SubscriptionService } from './subscription.service';
export const APIS = [AcquisitionService, NotificationService, SubscriptionService];
