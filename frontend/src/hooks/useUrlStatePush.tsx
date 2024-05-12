"use client";
import createQueryString from "@utils/createQueryString";
import { usePathname, useRouter, useSearchParams } from "next/navigation";

type ApplyUrlState = (keys: string[], values: (string | null)[]) => void;

export default function useUrlStatePush(): ApplyUrlState {
	const router = useRouter();
	const pathname = usePathname();
	const searchParams = useSearchParams();

	const applyUrlState: ApplyUrlState = (keys, values) => {
		let newQueryString = searchParams.toString();

		for (const [i, key] of keys.entries()) {
			newQueryString = createQueryString(newQueryString, key, values[i]);
		}

		newQueryString.slice(0, -1);

		router.push(`${pathname}?${newQueryString}`);
	};

	return applyUrlState;
}
