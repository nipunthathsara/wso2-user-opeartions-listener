package org.wso2.sample.user.operation.handler.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.UserStoreManager;
import org.wso2.carbon.user.core.common.AbstractUserOperationEventListener;

import java.util.Map;

public class UserOperationHandler extends AbstractUserOperationEventListener {
    private static Log log = LogFactory.getLog(UserOperationHandler.class);
    //An existing claim is used here for the simplicity, define custom claim for this
    private static String claimURI = "http://wso2.org/claims/title";

    @Override
    public int getExecutionOrderId() {
        return 1356;
    }

    @Override
    public boolean doPostAddUser(String userName, Object credential, String[] roleList, Map<String, String> claims,
                                 String profile, UserStoreManager userStoreManager) throws UserStoreException {
        //set claim value to true on user creation
        userStoreManager.setUserClaimValue(userName, claimURI, "true", null);
        return super.doPostAddUser(userName, credential, roleList, claims, profile, userStoreManager);
    }

    @Override
    public boolean doPostUpdateCredentialByAdmin(String userName, Object credential, UserStoreManager userStoreManager)
            throws UserStoreException {
        String initialReset = userStoreManager.getUserClaimValue(userName, claimURI, null);
        //if claim value is true, execute custom logic
        if("true".equals(initialReset)){
            //Your custom logic here

            //Setting claim value to false, to stop execution in forgot password flow
            userStoreManager.setUserClaimValue(userName, claimURI, "false", null);
        }
        return super.doPostUpdateCredentialByAdmin(userName, credential, userStoreManager);
    }
}
