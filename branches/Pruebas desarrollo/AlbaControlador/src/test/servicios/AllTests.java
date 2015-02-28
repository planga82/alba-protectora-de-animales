package test.servicios;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EspecieServiceTest.class, TipoInstitucionServiceTest.class, AnimalServiceTest.class, InstitucionServiceTest.class, PersonaServiceTest.class, GeneralServiceTest.class })
public class AllTests {}
