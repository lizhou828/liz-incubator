#Mybatis-generator

    version of Mybatis-generator: 1.3.2
    version of Mybatis: 3.2.8

###Run Environment

    JDK1.8+
    Tomcat 7.0+
    Spring 4.1.7+
    Mybatis 3.2.8+

###DB:
    Some common patterns

    table name pattern : t_user_log  or T_USER_LOG
    column name pattern :login_name or LOGIN_NAME

###Java:
    Some file name patterns:

    Pojo class name pattern : User
    Field name of Class pattern : loginName

    ActionName : UserAction
    FacadeName;  UserFacade
    ServiceName: UserService
    MapperName : UserMapper
    Mybatis config name: user.xml

###Generate codes schedule:

    1: Choose type of db
    2: Get table from the chosen db
    3: Generate pojo class based on the chosen table
    4: Generate codes of business-structure level
    5: Generate codes GUI level




