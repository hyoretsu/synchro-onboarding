export default function createQueryString(
	searchParams: URLSearchParams | string,
	name: string,
	value: string | null,
) {
	const params = new URLSearchParams(searchParams.toString());

	if (!value) {
		params.delete(name);
	} else {
		params.set(name, value);
	}

	return params.toString();
}
