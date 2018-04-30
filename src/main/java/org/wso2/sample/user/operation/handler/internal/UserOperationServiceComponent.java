package org.wso2.sample.user.operation.handler.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.user.core.listener.UserOperationEventListener;
import org.wso2.sample.user.operation.handler.impl.UserOperationHandler;

/**
 * @scr.component name="tenant.mgt.workflow" immediate="true"
 */
public class UserOperationServiceComponent {

    private static Log log = LogFactory.getLog(UserOperationServiceComponent.class);

    protected void activate(ComponentContext context) {
        BundleContext bundleContext = context.getBundleContext();
        bundleContext.registerService(UserOperationEventListener.class.getName(), new UserOperationHandler(), null);
    }
}
