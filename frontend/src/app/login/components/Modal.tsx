"use client";
import { closeModal } from "@app/login/actions";
import { Modal } from "@hyoretsu/react-components";

export default function FormModal() {
	return <Modal onConfirm={() => closeModal()}>Alo?</Modal>;
}
