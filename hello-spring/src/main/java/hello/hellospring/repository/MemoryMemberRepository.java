package hello.hellospring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public Optional<Member> findByName(String name) {
		return store.values().stream()
				 .filter(member -> member.getName().equals(name))
				 .findAny();
	}

	@Override
	public List<Member> findAll() {
		
		return null;
	}
	
}
