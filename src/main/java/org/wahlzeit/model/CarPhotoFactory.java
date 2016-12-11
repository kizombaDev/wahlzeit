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

import org.wahlzeit.exceptions.PhotoComponentException;
import org.wahlzeit.services.LogBuilder;
import org.wahlzeit.utils.AssertUtil;

import java.util.logging.Logger;

public class CarPhotoFactory extends PhotoFactory {

    private static final Logger log = Logger.getLogger(CarPhotoFactory.class.getName());
    private static CarPhotoFactory instance = null;

    protected CarPhotoFactory() {
        super();
    }


    /**
     * @return
     * @methodtype get
     */
    public static synchronized PhotoFactory getInstance() {
        if (instance == null) {
            log.config(LogBuilder.createSystemMessage().addAction("setting generic CarPhotoFactory").toString());
            setInstance(new CarPhotoFactory());
        }

        return instance;
    }

    /**
     * @return
     * @methodtype set
     */
    protected static synchronized void setInstance(CarPhotoFactory charPhotoFactory) {
        if (instance != null) {
            throw new IllegalStateException("attempt to initialize CarPhotoFactory twice");
        }

        instance = charPhotoFactory;
    }

    /**
     * @methodtype factory
     */
    @Override
    public Photo createPhoto() {
        return new CarPhoto();
    }

    /**
     * Creates a new photo with the specified id
     *
     * @param id
     */
    @Override
    public Photo createPhoto(PhotoId id) throws PhotoComponentException {
        try {
            AssertUtil.assertParameterIsNotNull(id, "id");
            return new CarPhoto(id);
        } catch (Exception e) {
            log.warning(e.toString());
            throw new PhotoComponentException(e);
        }
    }
}
