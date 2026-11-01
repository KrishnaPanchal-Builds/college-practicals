import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NewsletterService {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public boolean validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = pattern.matcher(email.trim());
        return matcher.matches();
    }

    public void processSubscription(String userEmail) {
        System.out.println("Processing subscription request for: " + userEmail);
        if (validateEmail(userEmail)) {
            System.out.println("Status: Valid Email Address.");
            System.out.println("Result: Subscription accepted! Welcome to the Newsletter.");
        } else {
            System.out.println("Status: Invalid Email Format.");
            System.out.println("Result: Subscription rejected! Please enter a valid email address.");
        }
        System.out.println("----------------------------------------");
    }
}

class EmailValidationDemo {
    public static void main(String[] args) {
        System.out.println("--- Online Newsletter Subscription Email Validation ---\n");

        NewsletterService service = new NewsletterService();

        String[] sampleEmails = {
            "student.tech@college.edu",
            "developer@company.org",
            "pankaj.sharma123@gmail.com",
            "invalid-email-at-domain.com",
            "user@domain",
            "user@.com.my",
            "hello.world@sub.domain.co.in",
            "@missingusername.com",
            ""
        };

        for (String email : sampleEmails) {
            service.processSubscription(email);
        }
    }
}
