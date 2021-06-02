package hello.hellospring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import hello.hellospring.domain.Member;

public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long, Member>store = new HashMap<>();
	private static long sequeence = 8L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequeence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(final String name) {
		return store.values().stream()
				 .filter(new Predicate<Member>() {
					@Override
					public boolean test(Member member) {
						return member.getName().equals(name);
					}
				})
				 .findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
}
