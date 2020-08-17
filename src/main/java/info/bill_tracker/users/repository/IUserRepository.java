package info.bill_tracker.users.repository;

public interface IUserRepository<T, S> {

    T registerUser(T t);

    long getIdFromDatabaseSequence(S s);

}
