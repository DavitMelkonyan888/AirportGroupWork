package airport_hibernate.service.single_ton_objects;

import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;

public class SingleTonService {
    private static final CompanyService COMPANY_SERVICE = CompanyService.getInstance();
    private static final PassengerService PASSENGER_SERVICE = PassengerService.getInstance();
    private static final TripService TRIP_SERVICE = TripService.getInstance();

    public static CompanyService getCompanyService() {
        return COMPANY_SERVICE;
    }

    public static PassengerService getPassengerService() {
        return PASSENGER_SERVICE;
    }

    public static TripService getTripService() {
        return TRIP_SERVICE;
    }
}
