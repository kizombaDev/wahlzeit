/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;


import javax.management.openmbean.KeyAlreadyExistsException;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarManager {

    private final HashMap<String, CarType> carTypeHashMap;
    private final List<Car> cars = new ArrayList<>();

    private CarManager(HashMap<String, CarType> carTypeHashMap) {
        this.carTypeHashMap = carTypeHashMap;
    }

    /**
     * @return
     * @methodtype factory
     */
    public static CarManagerBuilder builder() {
        return new CarManagerBuilder();
    }

    /**
     * @return
     * @methodtype factory
     */
    public Car createCar(String make, String model, Fuel fuel, Color color, double weight) {
        assertIfMakeAlreadyExists(make);
        CarType carType = getCarType(make);
        Car car = carType.createInstance(model, fuel, color, weight);
        cars.add(car);
        return car;
    }

    /**
     * @return
     * @methodtype get
     */
    public CarType getCarType(String make) {
        assertIfMakeAlreadyExists(make);
        return carTypeHashMap.get(make);
    }

    /**
     * @return
     * @methodtype get
     */
    public List<Car> getAllCars() {
        return cars;
    }

    private void assertIfMakeAlreadyExists(String make) {
        if (carTypeHashMap.containsKey(make) == false) {
            throw new KeyAlreadyExistsException("The make " + make + " does not exist");
        }
    }

    public static class CarManagerBuilder {
        private HashMap<String, CarType> carTypeHashMap = new HashMap<>();

        public CarManagerBuilder createMake(String make, String country) {

            assertIfMakeNotExists(make);
            return doCreateMake(make, country, null);
        }

        public CarManagerBuilder createMake(String make, String country, String baseType) {
            assertIfMakeAlreadyExists(baseType);
            assertIfMakeNotExists(make);

            return doCreateMake(make, country, carTypeHashMap.get(baseType));
        }

        public CarManager build() {
            CarManager carManager = new CarManager(carTypeHashMap);

            //reset the internal builder HashMap so that a new builder call starts with a emtpy HashMap
            carTypeHashMap = new HashMap<>();
            return carManager;
        }

        private CarManagerBuilder doCreateMake(String make, String country, CarType baseType) {
            carTypeHashMap.put(make, new CarType(baseType, make, country));
            return this;
        }

        private void assertIfMakeAlreadyExists(String make) {
            if (carTypeHashMap.containsKey(make) == false) {
                throw new KeyAlreadyExistsException("The make " + make + " does not exist");
            }
        }

        private void assertIfMakeNotExists(String baseType) {
            if (carTypeHashMap.containsKey(baseType)) {
                throw new UnsupportedOperationException("The base make " + baseType + " already exists");
            }
        }
    }
}
