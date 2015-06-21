package br.seufba.sistema.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EleitorTest.class, ChapaTest.class, VotacaoTest.class })
public class AllTests {

}
