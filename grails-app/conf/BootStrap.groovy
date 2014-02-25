import com.example.auth.Role
import com.example.auth.User
import com.example.auth.UserRole
import com.example.contact.Contact
import com.example.contact.Tag

class BootStrap {

    def init = { servletContext ->
        def admin = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def user = new User(username: 'user', password: 'pass').save(flush: true)

        UserRole.create user, admin, true

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1

        def t1 = new Tag(tagName: 'facebook')
        def t2 = new Tag(tagName: 'friend')
        def t3 = new Tag(tagName: 'me')

        def contact1 = new Contact(name: 'John', email: 'test', phone: '1234').save(flush: true)
        def contact2 = new Contact(name: 'Tom', email: 'test', phone: '1234').save(flush: true)
        def contact3 = new Contact(name: 'Jim', email: 'test', phone: '1234').save(flush: true)

        contact1.addToTags(t1)
        contact1.addToTags(t2)

        contact2.addToTags(t2)
        contact2.addToTags(t3)

        contact3.addToTags(t1)
        contact3.addToTags(t2)

        [contact1, contact2, contact3]*.save(flush: true)
    }

    def destroy = {
    }
}
