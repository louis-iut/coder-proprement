package fr.iut.iem.comics;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import fr.iut.iem.comics.data.model.remote.Comics;
import fr.iut.iem.comics.presentation.viewmodel.ComicsViewModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by QuentinGenevois on 13/12/2017.
 */
/*"id": 64966,
            "title": "Despicable Deadpool (2017) #288",
            "issueNumber": 288,
            "description": "DEADPOOL KILLS CABLE Parts 1 and 2. Deadpool’s going back to his vile beginnings as a mercenary and wanted killer. No more being a hero. No more X-Men. No more Avengers. And if he wants to break bad again, what’s more despicable than killing your best friend? Cable better get ready because his old friend Wade has him in the crosshairs. PLUS: Includes 3 bonus MARVEL PRIMER PAGES! Story by Robbie Thompson and a TBA artist!",
            "diamondCode": "AUG170836",
            "date": "2017-10-25T00:00:00-0400",
            "price": 3.99,
            "pageCount": 32,
            "image": "http://i.annihil.us/u/prod/marvel/i/mg/f/03/59e7b08528560.jpg",
            "creators": [
                {
                    "name": "Gerry Duggan",
                    "role": "writer"
                },
                {
                    "name": "Nicholas Filardi",
                    "role": "colorist"
                },
                {
                    "name": "Scott Koblish",
                    "role": "inker"
                }
            ] */
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
}
