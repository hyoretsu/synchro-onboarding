import Modal from "@components/Modal";
import { OpacityFilter } from "@hyoretsu/react-components";
import CreationForm from "./components/Form";

export default function AccountCreation() {
	return (
		<OpacityFilter>
			<Modal>
				<CreationForm />
			</Modal>
		</OpacityFilter>
	);
}
