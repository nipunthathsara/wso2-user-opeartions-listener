# wso2-tenant-handler
Tenant management listener to execute custom code in tenant’s life-cycle

## Configurations
1. Implement your custom logic

2. Build the project using **maven clean install** command.
3. Copy the **org.wso2.sample.user.operation.handler-1.0-SNAPSHOT.jar** to the 
   **<IS_HOME>/repository/components/dropins** directory.
4. Restart the server.

This sample is using a already defined claim for simplicity. Please be advised to define
a custom claim for this.

This is a sample user store operation handler to execute custom logic once the Ask Password
users have reset their password using the lin sent in the email.