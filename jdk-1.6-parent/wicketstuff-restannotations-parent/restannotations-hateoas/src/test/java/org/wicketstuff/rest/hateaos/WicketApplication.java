/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketstuff.rest.hateaos;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.rest.contenthandling.RestMimeTypes;
import org.wicketstuff.rest.contenthandling.serialdeserial.TextualWebSerialDeserial;
import org.wicketstuff.rest.hateoas.resources.HateoasResourceReference;
import org.wicketstuff.rest.resource.PersonsRestResource;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.wicketstuff.rest.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage()
    {
	return WebPage.class;
    }

    public WicketApplication()
    {
    }

    @Override
    public void init()
    {
	super.init();
	PersonsRestResource resource = new PersonsRestResource(new TextualWebSerialDeserial("", RestMimeTypes.APPLICATION_JSON, null));
	HateoasResourceReference reference = new HateoasResourceReference(resource);
	
	mountResource("/personsmanager", reference);
    }
}
