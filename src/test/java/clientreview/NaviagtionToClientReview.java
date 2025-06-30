package clientreview;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clientreview.pages.NavigationToClientReviewPage;

public class NaviagtionToClientReview extends Login {

    private NavigationToClientReviewPage navigationPage;

    public NaviagtionToClientReview() {
        super();
    }

    @BeforeMethod
    public void setUpNavigation() {
        navigationPage = new NavigationToClientReviewPage(driver);
        navigationPage.OpenSideMenuScreen();
        navigationPage.navaigateToReports();
        navigationPage.ClickToClientScreen();
    }

    @Test(priority = 1)
    public void searchPreExisted() {
        navigationPage.SearchElementClick();
    }

    @Test(priority = 2)
    public void searchWithCategoryFilter() throws InterruptedException {
        Thread.sleep(2000); 
        navigationPage.CategoryFilterSearch();
        navigationPage.DeSelectFilter();
        navigationPage.Selectcategory();
        navigationPage.myTeamRadioButton();
        navigationPage.SearchElementClick();
        
    }
    @Test(priority=3)
    public void markReviews()
    {
    	navigationPage.PendingReviewCount();
    	navigationPage.EllipsisClick();
    	navigationPage.MarkReviewNavigation();
    	navigationPage.discussionPoint();
    	navigationPage.selectDiscussionPoint();
    	navigationPage.datePicker();
    	navigationPage.enterDate();
    	navigationPage.commentAdd();
    	navigationPage.saveMarkreview();
    }

}
