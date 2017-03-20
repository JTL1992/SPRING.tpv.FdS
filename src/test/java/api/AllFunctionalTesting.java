package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({AdminResourceFunctionalTesting.class, UserResourceFunctionalTesting.class, TokenResourceFunctionalTesting.class,
        ArticleResourceFunctionalTesting.class, AlarmResourceFunctionalTesting.class, VoucherResourceFunctionalTesting.class,
        ProductResourceFunctionalTesting.class, InvoiceResourceFunctionalTesting.class})
public class AllFunctionalTesting {

}
