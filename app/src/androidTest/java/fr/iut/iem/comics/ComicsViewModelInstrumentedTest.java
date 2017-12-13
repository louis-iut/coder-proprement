package fr.iut.iem.comics;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by QuentinGenevois on 13/12/2017.
 */

public class ComicsViewModelInstrumentedTest {

    private Context context;
    private ComicsViewModel comicsViewModel;

    @Before
    public void initInstrumentedTest() {
        Comics comics = new Comics(64966,"Despicable Deadpool (2017) #288","DEADPOOL KILLS CABLE Parts 1 and 2.", "AUG170836", "2017-10-25T00:00:00-0400", 3.99, 32,"http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg", null);
        this.comicsViewModel = new ComicsViewModel(comics);
        this.context = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("fr.iut.iem.comics", appContext.getPackageName());
    }

    @Test
    public void getData_isCorrect() {
        assertEquals("Wednesday 25 October 2017", comicsViewModel.getDate(context));
    }

    @Test
    public void getData_isIncorrect() {
        assertNotEquals("mercredi 25 Octobre", comicsViewModel.getDate(context));
    }
}
